import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IUserplan } from '@/shared/model/userplan.model';

import UserplanService from './userplan.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Userplan extends Vue {
  @Inject('userplanService') private userplanService: () => UserplanService;
  private removeId: number = null;

  public userplans: IUserplan[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllUserplans();
  }

  public clear(): void {
    this.retrieveAllUserplans();
  }

  public retrieveAllUserplans(): void {
    this.isFetching = true;

    this.userplanService()
      .retrieve()
      .then(
        res => {
          this.userplans = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
