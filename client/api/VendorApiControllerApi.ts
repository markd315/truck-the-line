/**
 * Truck The Line API
 * These are API docs for Truck The Line, a 48hours project led by Mark Davis
 *
 * OpenAPI spec version: 1.0.0
 * Contact: mark_davis@ultimatesoftware.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

import * as models from '../model/models';

/* tslint:disable:no-unused-variable member-ordering */

export class VendorApiControllerApi {
    protected basePath = 'http://localhost:8080/truck';
    public defaultHeaders : any = {};

    static $inject: string[] = ['$http', '$httpParamSerializer', 'basePath'];

    constructor(protected $http: ng.IHttpService, protected $httpParamSerializer?: (d: any) => any, basePath?: string) {
        if (basePath !== undefined) {
            this.basePath = basePath;
        }
    }

    /**
     * 
     * @summary Create a new menu
     * @param body order placed for purchasing the pet
     */
    public createMenu (body: models.Vendor, extraHttpRequestParams?: any ) : ng.IHttpPromise<models.Vendor> {
        const localVarPath = this.basePath + '/vendor';

        let queryParameters: any = {};
        let headerParams: any = (<any>Object).assign({}, this.defaultHeaders);
        // verify required parameter 'body' is not null or undefined
        if (body === null || body === undefined) {
            throw new Error('Required parameter body was null or undefined when calling createMenu.');
        }

        let httpRequestParams: ng.IRequestConfig = {
            method: 'POST',
            url: localVarPath,
            data: body,
            params: queryParameters,
            headers: headerParams
        };

        if (extraHttpRequestParams) {
            httpRequestParams = (<any>Object).assign(httpRequestParams, extraHttpRequestParams);
        }

        return this.$http(httpRequestParams);
    }
    /**
     * For valid response try integer IDs with positive integer value.         Negative or non-integer values will generate API errors
     * @summary Remove a vendor from the accessible list
     * @param vendorId ID of the order that needs to be deleted
     */
    public deleteVendor (vendorId: number, extraHttpRequestParams?: any ) : ng.IHttpPromise<{}> {
        const localVarPath = this.basePath + '/vendor/{vendorId}'
            .replace('{' + 'vendorId' + '}', encodeURIComponent(String(vendorId)));

        let queryParameters: any = {};
        let headerParams: any = (<any>Object).assign({}, this.defaultHeaders);
        // verify required parameter 'vendorId' is not null or undefined
        if (vendorId === null || vendorId === undefined) {
            throw new Error('Required parameter vendorId was null or undefined when calling deleteVendor.');
        }

        let httpRequestParams: ng.IRequestConfig = {
            method: 'DELETE',
            url: localVarPath,
            params: queryParameters,
            headers: headerParams
        };

        if (extraHttpRequestParams) {
            httpRequestParams = (<any>Object).assign(httpRequestParams, extraHttpRequestParams);
        }

        return this.$http(httpRequestParams);
    }
    /**
     * For valid response try integer IDs with positive integer value.         Negative or non-integer values will generate API errors
     * @summary Edit a vendor from the accessible list
     * @param vendorId ID of the order that needs to be deleted
     * @param body body
     */
    public editVendor (vendorId: number, body: models.Vendor, extraHttpRequestParams?: any ) : ng.IHttpPromise<{}> {
        const localVarPath = this.basePath + '/vendor/{vendorId}'
            .replace('{' + 'vendorId' + '}', encodeURIComponent(String(vendorId)));

        let queryParameters: any = {};
        let headerParams: any = (<any>Object).assign({}, this.defaultHeaders);
        // verify required parameter 'vendorId' is not null or undefined
        if (vendorId === null || vendorId === undefined) {
            throw new Error('Required parameter vendorId was null or undefined when calling editVendor.');
        }

        // verify required parameter 'body' is not null or undefined
        if (body === null || body === undefined) {
            throw new Error('Required parameter body was null or undefined when calling editVendor.');
        }

        let httpRequestParams: ng.IRequestConfig = {
            method: 'PUT',
            url: localVarPath,
            data: body,
            params: queryParameters,
            headers: headerParams
        };

        if (extraHttpRequestParams) {
            httpRequestParams = (<any>Object).assign(httpRequestParams, extraHttpRequestParams);
        }

        return this.$http(httpRequestParams);
    }
    /**
     * Returns a list of possible vendors
     * @summary Returns vendor inventories
     * @param vendorId ID of pet that needs to be fetched
     */
    public getAllInventory (vendorId: number, extraHttpRequestParams?: any ) : ng.IHttpPromise<any> {
        const localVarPath = this.basePath + '/vendor'
            .replace('{' + 'vendorId' + '}', encodeURIComponent(String(vendorId)));

        let queryParameters: any = {};
        let headerParams: any = (<any>Object).assign({}, this.defaultHeaders);
        // verify required parameter 'vendorId' is not null or undefined
        if (vendorId === null || vendorId === undefined) {
            throw new Error('Required parameter vendorId was null or undefined when calling getAllInventory.');
        }

        let httpRequestParams: ng.IRequestConfig = {
            method: 'GET',
            url: localVarPath,
            params: queryParameters,
            headers: headerParams
        };

        if (extraHttpRequestParams) {
            httpRequestParams = (<any>Object).assign(httpRequestParams, extraHttpRequestParams);
        }

        return this.$http(httpRequestParams);
    }
    /**
     * Returns a list of possible vendors
     * @summary Returns vendor inventory
     * @param vendorId ID of pet that needs to be fetched
     */
    public getInventory (vendorId: number, extraHttpRequestParams?: any ) : ng.IHttpPromise<any> {
        const localVarPath = this.basePath + '/vendor/{vendorId}'
            .replace('{' + 'vendorId' + '}', encodeURIComponent(String(vendorId)));

        let queryParameters: any = {};
        let headerParams: any = (<any>Object).assign({}, this.defaultHeaders);
        // verify required parameter 'vendorId' is not null or undefined
        if (vendorId === null || vendorId === undefined) {
            throw new Error('Required parameter vendorId was null or undefined when calling getInventory.');
        }

        let httpRequestParams: ng.IRequestConfig = {
            method: 'GET',
            url: localVarPath,
            params: queryParameters,
            headers: headerParams
        };

        if (extraHttpRequestParams) {
            httpRequestParams = (<any>Object).assign(httpRequestParams, extraHttpRequestParams);
        }

        return this.$http(httpRequestParams);
    }
}
