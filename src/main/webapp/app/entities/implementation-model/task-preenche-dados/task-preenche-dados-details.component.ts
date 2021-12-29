import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskPreencheDadosService from './task-preenche-dados.service';
import { TaskPreencheDadosContext } from './task-preenche-dados.model';

@Component
export default class TaskPreencheDadosDetailsComponent extends Vue {
  private taskPreencheDadosService: TaskPreencheDadosService = new TaskPreencheDadosService();
  private taskContext: TaskPreencheDadosContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskPreencheDadosService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
