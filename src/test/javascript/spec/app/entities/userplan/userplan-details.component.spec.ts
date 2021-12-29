/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import UserplanDetailComponent from '@/entities/userplan/userplan-details.vue';
import UserplanClass from '@/entities/userplan/userplan-details.component';
import UserplanService from '@/entities/userplan/userplan.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Userplan Management Detail Component', () => {
    let wrapper: Wrapper<UserplanClass>;
    let comp: UserplanClass;
    let userplanServiceStub: SinonStubbedInstance<UserplanService>;

    beforeEach(() => {
      userplanServiceStub = sinon.createStubInstance<UserplanService>(UserplanService);

      wrapper = shallowMount<UserplanClass>(UserplanDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { userplanService: () => userplanServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundUserplan = { id: 123 };
        userplanServiceStub.find.resolves(foundUserplan);

        // WHEN
        comp.retrieveUserplan(123);
        await comp.$nextTick();

        // THEN
        expect(comp.userplan).toBe(foundUserplan);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundUserplan = { id: 123 };
        userplanServiceStub.find.resolves(foundUserplan);

        // WHEN
        comp.beforeRouteEnter({ params: { userplanId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.userplan).toBe(foundUserplan);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
