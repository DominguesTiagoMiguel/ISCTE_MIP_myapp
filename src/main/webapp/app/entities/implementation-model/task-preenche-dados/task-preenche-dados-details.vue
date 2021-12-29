<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('myappApp.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskPreencheDados.address')">address</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="address"
                id="userplan-address"
                data-cy="address"
                v-model="taskContext.implementationModel.userplan.address"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskPreencheDados.postalCode')">postalCode</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="postalCode"
                id="userplan-postalCode"
                data-cy="postalCode"
                v-model="taskContext.implementationModel.userplan.postalCode"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskPreencheDados.city')">city</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="city"
                id="userplan-city"
                data-cy="city"
                v-model="taskContext.implementationModel.userplan.city"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/ImplementationModel/task/TaskPreencheDados/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-preenche-dados-details.component.ts"></script>
