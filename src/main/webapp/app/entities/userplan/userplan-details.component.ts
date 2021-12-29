import { Component, Vue, Inject } from 'vue-property-decorator';

import { IUserplan } from '@/shared/model/userplan.model';
import UserplanService from './userplan.service';

@Component
export default class UserplanDetails extends Vue {
  @Inject('userplanService') private userplanService: () => UserplanService;
  public userplan: IUserplan = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.userplanId) {
        vm.retrieveUserplan(to.params.userplanId);
      }
    });
  }

  public retrieveUserplan(userplanId) {
    this.userplanService()
      .find(userplanId)
      .then(res => {
        this.userplan = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
