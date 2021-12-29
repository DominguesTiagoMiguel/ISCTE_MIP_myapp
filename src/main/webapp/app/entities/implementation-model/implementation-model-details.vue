<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="implementationModel.processInstance">
        <h2 class="jh-entity-heading" data-cy="implementationModelDetailsHeading">
          <span v-text="$t('myappApp.implementationModel.detail.title')">ImplementationModel</span> {{ implementationModel.id }}
        </h2>
        <akip-show-process-instance :processInstance="implementationModel.processInstance">
          <template v-slot:title>
            <span v-text="$t('myappApp.implementationModel.detail.title')">ImplementationModel</span> #{{ implementationModel.id }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="implementationModel.userplan">
              <h5 class="card-header">
                <span class="title"> Userplan #{{ implementationModel.userplan.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.implementationModel.firstName')">firstName</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="firstName"
                    id="userplan-firstName"
                    data-cy="firstName"
                    v-model="implementationModel.userplan.firstName"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.implementationModel.lastName')">lastName</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="lastName"
                    id="userplan-lastName"
                    data-cy="lastName"
                    v-model="implementationModel.userplan.lastName"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.implementationModel.address')">address</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="address"
                    id="userplan-address"
                    data-cy="address"
                    v-model="implementationModel.userplan.address"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.implementationModel.postalCode')">postalCode</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="postalCode"
                    id="userplan-postalCode"
                    data-cy="postalCode"
                    v-model="implementationModel.userplan.postalCode"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.implementationModel.city')">city</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="city"
                    id="userplan-city"
                    data-cy="city"
                    v-model="implementationModel.userplan.city"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.implementationModel.email')">email</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="email"
                    id="userplan-email"
                    data-cy="email"
                    v-model="implementationModel.userplan.email"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.implementationModel.password')">password</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="password"
                    id="userplan-password"
                    data-cy="password"
                    v-model="implementationModel.userplan.password"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.implementationModel.discountCode')">discountCode</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="discountCode"
                    id="userplan-discountCode"
                    data-cy="discountCode"
                    v-model="implementationModel.userplan.discountCode"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.implementationModel.confirmationUser')">confirmationUser</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="confirmationUser"
                    id="userplan-confirmationUser"
                    data-cy="confirmationUser"
                    v-model="implementationModel.userplan.confirmationUser"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.implementationModel.user')">user</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="user"
                    id="userplan-user"
                    data-cy="user"
                    v-model="implementationModel.userplan.user"
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./implementation-model-details.component.ts"></script>
