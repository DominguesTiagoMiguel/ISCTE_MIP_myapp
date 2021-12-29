<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="myappApp.userStartForm.home.createOrEditLabel"
          data-cy="UserStartFormCreateUpdateHeading"
          v-text="$t('myappApp.userStartForm.home.createOrEditLabel')"
        >
          Create or edit a UserStartForm
        </h2>
        <div v-if="implementationModel.processInstance">
          <akip-show-process-definition :processDefinition="implementationModel.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="implementationModel.userplan">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.userStartForm.firstName')" for="user-start-form-firstName"
                    >First Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="firstName"
                    id="user-start-form-firstName"
                    data-cy="firstName"
                    :class="{
                      valid: !$v.implementationModel.userplan.firstName.$invalid,
                      invalid: $v.implementationModel.userplan.firstName.$invalid,
                    }"
                    v-model="$v.implementationModel.userplan.firstName.$model"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.userStartForm.lastName')" for="user-start-form-lastName"
                    >Last Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="lastName"
                    id="user-start-form-lastName"
                    data-cy="lastName"
                    :class="{
                      valid: !$v.implementationModel.userplan.lastName.$invalid,
                      invalid: $v.implementationModel.userplan.lastName.$invalid,
                    }"
                    v-model="$v.implementationModel.userplan.lastName.$model"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.userStartForm.email')" for="user-start-form-email">Email</label>
                  <input
                    type="text"
                    class="form-control"
                    name="email"
                    id="user-start-form-email"
                    data-cy="email"
                    :class="{
                      valid: !$v.implementationModel.userplan.email.$invalid,
                      invalid: $v.implementationModel.userplan.email.$invalid,
                    }"
                    v-model="$v.implementationModel.userplan.email.$model"
                  />
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.implementationModel.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./user-start-form-init.component.ts"></script>
