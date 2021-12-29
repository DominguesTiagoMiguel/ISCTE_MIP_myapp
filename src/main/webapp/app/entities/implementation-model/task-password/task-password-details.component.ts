import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskPasswordService from './task-password.service';
import { TaskPasswordContext } from './task-password.model';

@Component
export default class TaskPasswordDetailsComponent extends Vue {
  private taskPasswordService: TaskPasswordService = new TaskPasswordService();
  private taskContext: TaskPasswordContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskPasswordService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
