import { Component, Vue, Inject } from 'vue-property-decorator';

import { IImplementationModel, ImplementationModel } from '@/shared/model/implementation-model.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { Userplan } from '@/shared/model/userplan.model';
import ImplementationModelService from './implementation-model.service';

const validations: any = {
  implementationModel: {
    userplan: {
      firstName: {},
      lastName: {},
      email: {},
    },
  },
};

@Component({
  validations,
})
export default class UserStartFormInitComponent extends Vue {
  @Inject('implementationModelService') private implementationModelService: () => ImplementationModelService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'ImplementationModel';
  public implementationModel: IImplementationModel = new ImplementationModel();

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initUserStartForm();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;

    this.implementationModelService()
      .create(this.implementationModel)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('myappApp.userStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initUserStartForm(): void {
    this.implementationModel.userplan = new Userplan();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.implementationModel.processInstance = new ProcessInstance();
      this.implementationModel.processInstance.processDefinition = res;
    });
  }
}
