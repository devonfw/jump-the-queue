import { UserResponse, AccessCodeResponse, TermsResponse } from './response-models/interfaces';

export const user: UserResponse = {
    id: 101,
    modificationCounter: 0,
    revision: 1,
    token: 'tokentest',
    email: 'test@test.com',
    name: 'Test',
    phone: '666666666'
};

export const accessCode: AccessCodeResponse = {
    accessCode: {
        id: 101,
        name: 'test',
        phone: '666666666',
        email: 'test@test.com',
        code: 100,
        priority: false,
        creationTime: '1511878544',
        startTime: null,
        estimatedTime: '1512065206',
        endTime: null,
    },
    queue: {
        id: 100,
        descriptionText: 'MWC Queue',
        logo: 'assets/images/queue_logo.png'
    }
};

export const attendingAccessCode: AccessCodeResponse = {
    accessCode: {
        id: 105,
        name: 'test',
        phone: '666666666',
        email: 'test@test.com',
        code: 1,
        priority: false,
        creationTime: '1511878544',
        startTime: null,
        estimatedTime: '1512065206',
        endTime: null,
    },
    queue: {
        id: 100,
        descriptionText: 'MWC Queue',
        logo: 'assets/images/queue_logo.png'
    }
};

export const terms: TermsResponse = {
    id: 1,
    modificationCounter: 1,
    revision: null,
    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum semper sollicitudin condimentum. ' +
    'Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Maecenas ac posuere metus. ' +
    'Quisque a velit congue, maximus justo ut, mollis nisi. Nunc lectus dolor, gravida at blandit vel, aliquet in felis.' +
    'Duis elementum interdum metus, non consectetur mauris condimentum eu. Sed tincidunt eu dui nec ultricies. Vestibulum ' +
    'sagittis, mauris vel vestibulum tristique, diam felis blandit lacus, at gravida risus purus accumsan justo. Morbi tempor ' +
    'semper nunc.\n\nSuspendisse vehicula lectus nec risus dignissim, vitae sodales elit condimentum.Nulla convallis elementum ' +
    'nibh vel sollicitudin.Donec elementum purus et felis efficitur venenatis.Mauris ac imperdiet mi.Sed cursus porttitor efficitur.' +
    ' Ut non sapien porttitor, tempor nibh et, vestibulum lorem.Etiam sit amet elit ut justo venenatis maximus a eu tellus.Fusce tempor' +
    'accumsan maximus.Vivamus cursus nulla nec scelerisque fringilla.Proin velit metus, tristique et facilisis iaculis, dignissim' +
    'siaculis elit.'
};
