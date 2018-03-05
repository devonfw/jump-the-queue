import { HttpEvent, Context, Code } from '../../handlers/types';
import { register } from '../../handlers/Http/POST/register-handler';
import { search } from '../../handlers/Http/POST/search-handler';
import { expect } from 'chai';
import * as _ from 'lodash';
import oasp4fn from '@oasp/oasp4fn';

const EVENT = {
    method: 'POST',
    path: {},
    body: {},
    query: {},
    headers: {}
}

let context: Context;

let code: string;

describe('register', function () {
    this.timeout(6000);
    it('The register should return an object, with the code and dateAndTime properties', (done: Function) => {
        let event =  <HttpEvent>_.assign({}, EVENT, { body: { "name": "David", "email": "somenthing@something.com", "phone": "658974145"}});
        register(event, context, (err: Error, res: Code) => {
            try {
                expect(err).to.be.null;
                expect(res).to.be.an('object').that.contains.all.keys('code', 'dateAndTime');
                code = res.code;
                done();
            } catch (error) {
                done(error);
            }
        })
    });
});

describe('search', function () {
    this.timeout(6000);
    it('The search should return an array with the items of the table Queue', (done: Function) => {
        search(EVENT, context, (err: Error, res: object[]) => {
            try {
                expect(err).to.be.null;
                expect(res).to.be.an('Array');
                res.forEach(obj => {
                    expect(obj).to.be.an('object');
                    expect(obj).to.contain.all.keys(
                        ['name', 'email', 'phone', 'code', 'dateAndTime']
                    );
                })
                done();
            } catch (error) {
                done(error);
            }
        })
    });
});

after(async () => {
    if(code)
        await oasp4fn.delete('Queue', code).promise();
});