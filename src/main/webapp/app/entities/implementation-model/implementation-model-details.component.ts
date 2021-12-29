import { Component, Vue, Inject } from 'vue-property-decorator';

import { IImplementationModel } from '@/shared/model/implementation-model.model';
import ImplementationModelService from './implementation-model.service';

@Component
export default class ImplementationModelDetailsComponent extends Vue {
  @Inject('implementationModelService') private implementationModelService: () => ImplementationModelService;
  public implementationModel: IImplementationModel = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveImplementationModel(to.params.processInstanceId);
      }
    });
  }

  public retrieveImplementationModel(implementationModelId) {
    this.isFetching = true;
    this.implementationModelService()
      .find(implementationModelId)
      .then(
        res => {
          this.implementationModel = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
