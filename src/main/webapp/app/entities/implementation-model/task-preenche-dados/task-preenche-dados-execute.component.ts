import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskPreencheDadosService from './task-preenche-dados.service';
import { TaskPreencheDadosContext } from './task-preenche-dados.model';

const validations: any = {
  taskContext: {
    implementationModel: {
      userplan: {
        address: {},
        postalCode: {},
        city: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskPreencheDadosExecuteComponent extends Vue {
  private taskPreencheDadosService: TaskPreencheDadosService = new TaskPreencheDadosService();
  private taskContext: TaskPreencheDadosContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskPreencheDadosService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskPreencheDadosService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
