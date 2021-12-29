import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskInsertDiscountService from './task-insert-discount.service';
import { TaskInsertDiscountContext } from './task-insert-discount.model';

const validations: any = {
  taskContext: {
    implementationModel: {
      userplan: {
        discountCode: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskInsertDiscountExecuteComponent extends Vue {
  private taskInsertDiscountService: TaskInsertDiscountService = new TaskInsertDiscountService();
  private taskContext: TaskInsertDiscountContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskInsertDiscountService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskInsertDiscountService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
