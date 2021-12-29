<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="userplan">
        <h2 class="jh-entity-heading" data-cy="userplanDetailsHeading">
          <span v-text="$t('myappApp.userplan.detail.title')">Userplan</span> {{ userplan.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('myappApp.userplan.firstName')">First Name</span>
          </dt>
          <dd>
            <span>{{ userplan.firstName }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.userplan.lastName')">Last Name</span>
          </dt>
          <dd>
            <span>{{ userplan.lastName }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.userplan.address')">Address</span>
          </dt>
          <dd>
            <span>{{ userplan.address }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.userplan.postalCode')">Postal Code</span>
          </dt>
          <dd>
            <span>{{ userplan.postalCode }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.userplan.city')">City</span>
          </dt>
          <dd>
            <span>{{ userplan.city }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.userplan.email')">Email</span>
          </dt>
          <dd>
            <span>{{ userplan.email }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.userplan.password')">Password</span>
          </dt>
          <dd>
            <span>{{ userplan.password }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.userplan.discountCode')">Discount Code</span>
          </dt>
          <dd>
            <span>{{ userplan.discountCode }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.userplan.confirmationUser')">Confirmation User</span>
          </dt>
          <dd>
            <span>{{ userplan.confirmationUser }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.userplan.user')">User</span>
          </dt>
          <dd>
            <span>{{ userplan.user }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./userplan-details.component.ts"></script>
