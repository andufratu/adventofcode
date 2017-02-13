import {Md5} from 'ts-md5/dist/md5';

const buildHash = (seed: string, nr: number) =>
  (<string> Md5.hashStr(seed + nr.toString()));

const checkHash = (hash: string, count: number) =>
  hash.substr(0, count) === Array(count + 1).join('0');

const find = (seed: string, count = 5) => {
  let i = 1;
  let hash = buildHash(seed, i);

  while (!checkHash(hash, count)) {
    hash = buildHash(seed, ++i);
  }

  return i;
};

export {find}
