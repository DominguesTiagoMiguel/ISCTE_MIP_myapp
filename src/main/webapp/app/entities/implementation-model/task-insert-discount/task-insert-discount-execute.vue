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
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskInsertDiscount.discountCode')"
                for="task-insert-discount-discountCode"
                >Discount Code</label
              >
              <input
                type="text"
                class="form-control"
                name="discountCode"
                id="task-insert-discount-discountCode"
                data-cy="discountCode"
                :class="{
                  valid: !$v.taskContext.implementationModel.userplan.discountCode.$invalid,
                  invalid: $v.taskContext.implementationModel.userplan.discountCode.$invalid,
                }"
                v-model="$v.taskContext.implementationModel.userplan.discountCode.$model"
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

<script lang="ts" src="./task-insert-discount-execute.component.ts"></script>
