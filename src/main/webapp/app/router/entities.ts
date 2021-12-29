import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const Userplan = () => import('@/entities/userplan/userplan.vue');
// prettier-ignore
const UserplanDetails = () => import('@/entities/userplan/userplan-details.vue');
// prettier-ignore
const ImplementationModelDetails = () => import('@/entities/implementation-model/implementation-model-details.vue');
// prettier-ignore
const ImplementationModelList = () => import('@/entities/implementation-model/implementation-model-list.vue');
// prettier-ignore
const UserStartFormInit = () => import('@/entities/implementation-model/user-start-form-init.vue');
// prettier-ignore
const ImplementationModel_TaskPreencheDadosDetails = () => import('@/entities/implementation-model/task-preenche-dados/task-preenche-dados-details.vue');
// prettier-ignore
const ImplementationModel_TaskPreencheDadosExecute = () => import('@/entities/implementation-model/task-preenche-dados/task-preenche-dados-execute.vue');
// prettier-ignore
const ImplementationModel_TaskInsertDiscountDetails = () => import('@/entities/implementation-model/task-insert-discount/task-insert-discount-details.vue');
// prettier-ignore
const ImplementationModel_TaskInsertDiscountExecute = () => import('@/entities/implementation-model/task-insert-discount/task-insert-discount-execute.vue');
// prettier-ignore
const ImplementationModel_TaskPasswordDetails = () => import('@/entities/implementation-model/task-password/task-password-details.vue');
// prettier-ignore
const ImplementationModel_TaskPasswordExecute = () => import('@/entities/implementation-model/task-password/task-password-execute.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/userplan',
    name: 'Userplan',
    component: Userplan,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/userplan/:userplanId/view',
    name: 'UserplanView',
    component: UserplanDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ImplementationModel/instance/:processInstanceId/view',
    name: 'ImplementationModelView',
    component: ImplementationModelDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ImplementationModel/instances',
    name: 'ImplementationModelList',
    component: ImplementationModelList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ImplementationModel/init',
    name: 'UserStartFormInit',
    component: UserStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ImplementationModel/task/TaskPreencheDados/:taskInstanceId/view',
    name: 'ImplementationModel_TaskPreencheDadosDetails',
    component: ImplementationModel_TaskPreencheDadosDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ImplementationModel/task/TaskPreencheDados/:taskInstanceId/execute',
    name: 'ImplementationModel_TaskPreencheDadosExecute',
    component: ImplementationModel_TaskPreencheDadosExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ImplementationModel/task/TaskInsertDiscount/:taskInstanceId/view',
    name: 'ImplementationModel_TaskInsertDiscountDetails',
    component: ImplementationModel_TaskInsertDiscountDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ImplementationModel/task/TaskInsertDiscount/:taskInstanceId/execute',
    name: 'ImplementationModel_TaskInsertDiscountExecute',
    component: ImplementationModel_TaskInsertDiscountExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ImplementationModel/task/TaskPassword/:taskInstanceId/view',
    name: 'ImplementationModel_TaskPasswordDetails',
    component: ImplementationModel_TaskPasswordDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ImplementationModel/task/TaskPassword/:taskInstanceId/execute',
    name: 'ImplementationModel_TaskPasswordExecute',
    component: ImplementationModel_TaskPasswordExecute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
