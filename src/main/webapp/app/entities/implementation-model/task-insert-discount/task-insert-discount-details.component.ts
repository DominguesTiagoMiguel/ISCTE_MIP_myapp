import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskInsertDiscountService from './task-insert-discount.service';
import { TaskInsertDiscountContext } from './task-insert-discount.model';

@Component
export default class TaskInsertDiscountDetailsComponent extends Vue {
  private taskInsertDiscountService: TaskInsertDiscountService = new TaskInsertDiscountService();
  private taskContext: TaskInsertDiscountContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskInsertDiscountService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
