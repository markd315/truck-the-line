import * as api from './api/api';
import * as angular from 'angular';

const apiModule = angular.module('api', [])
.service('OrderApiControllerApi', api.OrderApiControllerApi)
.service('PrintApiControllerApi', api.PrintApiControllerApi)
.service('UserApiControllerApi', api.UserApiControllerApi)
.service('VendorApiControllerApi', api.VendorApiControllerApi)

export default apiModule;
