/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import UserplanComponent from '@/entities/userplan/userplan.vue';
import UserplanClass from '@/entities/userplan/userplan.component';
import UserplanService from '@/entities/userplan/userplan.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('Userplan Management Component', () => {
    let wrapper: Wrapper<UserplanClass>;
    let comp: UserplanClass;
    let userplanServiceStub: SinonStubbedInstance<UserplanService>;

    beforeEach(() => {
      userplanServiceStub = sinon.createStubInstance<UserplanService>(UserplanService);
      userplanServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<UserplanClass>(UserplanComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          userplanService: () => userplanServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      userplanServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllUserplans();
      await comp.$nextTick();

      // THEN
      expect(userplanServiceStub.retrieve.called).toBeTruthy();
      expect(comp.userplans[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
