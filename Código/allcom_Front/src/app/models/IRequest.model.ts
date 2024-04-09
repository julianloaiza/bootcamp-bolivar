export interface IRequest {
  requestId: number;
  userNameId: string;
  factureId: number;
  state: string;
  description: string;
}

export interface IRequestDTO extends Omit<IRequest, 'requestId'> {}
