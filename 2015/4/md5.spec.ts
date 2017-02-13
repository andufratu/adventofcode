import {find} from './md5';

describe('find', () => {
  it('finds 609043 for seed abcdef and count of 5', () => {
    expect(find('abcdef')).toBe(609043);
  });

  it('finds 1048970 for seed pqrstuv and count of 5', () => {
    expect(find('pqrstuv')).toBe(1048970);
  });

  it('finds 117946 for seed ckczppom and count of 5', () => {
    expect(find('ckczppom')).toBe(117946);
  });

  it('finds 3938038 for seed ckczppom and count of 6', () => {
    expect(find('ckczppom', 6)).toBe(3938038);
  });
});
