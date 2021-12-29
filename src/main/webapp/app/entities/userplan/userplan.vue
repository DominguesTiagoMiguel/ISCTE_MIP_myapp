<template>
  <div>
    <h2 id="page-heading" data-cy="UserplanHeading">
      <span v-text="$t('myappApp.userplan.home.title')" id="userplan-heading">Userplans</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('myappApp.userplan.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && userplans && userplans.length === 0">
      <span v-text="$t('myappApp.userplan.home.notFound')">No userplans found</span>
    </div>
    <div class="table-responsive" v-if="userplans && userplans.length > 0">
      <table class="table table-striped" aria-describedby="userplans">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('myappApp.userplan.firstName')">First Name</span></th>
            <th scope="row"><span v-text="$t('myappApp.userplan.lastName')">Last Name</span></th>
            <th scope="row"><span v-text="$t('myappApp.userplan.address')">Address</span></th>
            <th scope="row"><span v-text="$t('myappApp.userplan.postalCode')">Postal Code</span></th>
            <th scope="row"><span v-text="$t('myappApp.userplan.city')">City</span></th>
            <th scope="row"><span v-text="$t('myappApp.userplan.email')">Email</span></th>
            <th scope="row"><span v-text="$t('myappApp.userplan.password')">Password</span></th>
            <th scope="row"><span v-text="$t('myappApp.userplan.discountCode')">Discount Code</span></th>
            <th scope="row"><span v-text="$t('myappApp.userplan.confirmationUser')">Confirmation User</span></th>
            <th scope="row"><span v-text="$t('myappApp.userplan.user')">User</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="userplan in userplans" :key="userplan.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'UserplanView', params: { userplanId: userplan.id } }">{{ userplan.id }}</router-link>
            </td>
            <td>{{ userplan.firstName }}</td>
            <td>{{ userplan.lastName }}</td>
            <td>{{ userplan.address }}</td>
            <td>{{ userplan.postalCode }}</td>
            <td>{{ userplan.city }}</td>
            <td>{{ userplan.email }}</td>
            <td>{{ userplan.password }}</td>
            <td>{{ userplan.discountCode }}</td>
            <td>{{ userplan.confirmationUser }}</td>
            <td>{{ userplan.user }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'UserplanView', params: { userplanId: userplan.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="myappApp.userplan.delete.question" data-cy="userplanDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-userplan-heading" v-text="$t('myappApp.userplan.delete.question', { id: removeId })">
          Are you sure you want to delete this Userplan?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-userplan"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeUserplan()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./userplan.component.ts"></script>
