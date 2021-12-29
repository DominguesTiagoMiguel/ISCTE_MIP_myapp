import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskPasswordService from './task-password.service';
import { TaskPasswordContext } from './task-password.model';

const validations: any = {
  taskContext: {
    implementationModel: {
      userplan: {
        password: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskPasswordExecuteComponent extends Vue {
  private taskPasswordService: TaskPasswordService = new TaskPasswordService();
  private taskContext: TaskPasswordContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskPasswordService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskPasswordService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
