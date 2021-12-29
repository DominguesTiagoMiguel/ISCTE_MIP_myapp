<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('myappApp.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskPreencheDados.address')" for="task-preenche-dados-address"
                >Address</label
              >
              <input
                type="text"
                class="form-control"
                name="address"
                id="task-preenche-dados-address"
                data-cy="address"
                :class="{
                  valid: !$v.taskContext.implementationModel.userplan.address.$invalid,
                  invalid: $v.taskContext.implementationModel.userplan.address.$invalid,
                }"
                v-model="$v.taskContext.implementationModel.userplan.address.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskPreencheDados.postalCode')" for="task-preenche-dados-postalCode"
                >Postal Code</label
              >
              <input
                type="text"
                class="form-control"
                name="postalCode"
                id="task-preenche-dados-postalCode"
                data-cy="postalCode"
                :class="{
                  valid: !$v.taskContext.implementationModel.userplan.postalCode.$invalid,
                  invalid: $v.taskContext.implementationModel.userplan.postalCode.$invalid,
                }"
                v-model="$v.taskContext.implementationModel.userplan.postalCode.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskPreencheDados.city')" for="task-preenche-dados-city">City</label>
              <input
                type="text"
                class="form-control"
                name="city"
                id="task-preenche-dados-city"
                data-cy="city"
                :class="{
                  valid: !$v.taskContext.implementationModel.userplan.city.$invalid,
                  invalid: $v.taskContext.implementationModel.userplan.city.$invalid,
                }"
                v-model="$v.taskContext.implementationModel.userplan.city.$model"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-preenche-dados-execute.component.ts"></script>
