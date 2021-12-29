import { Component, Vue, Inject } from 'vue-property-decorator';
import { IImplementationModel } from '@/shared/model/implementation-model.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import ImplementationModelService from './implementation-model.service';

@Component
export default class ImplementationModelListComponent extends Vue {
  @Inject('implementationModelService') private implementationModelService: () => ImplementationModelService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'ImplementationModel';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public implementationModelList: IImplementationModel[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.implementationModelService()
      .retrieve()
      .then(
        res => {
          this.implementationModelList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
