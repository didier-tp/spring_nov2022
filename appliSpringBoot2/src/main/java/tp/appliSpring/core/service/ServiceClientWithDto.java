package tp.appliSpring.core.service;

import tp.appliSpring.dto.ClientDto;
import tp.appliSpring.dto.ClientDtoEx;

public interface ServiceClientWithDto extends GenericServiceWithDto<ClientDto,ClientDtoEx,Long>{

	public ClientDtoEx searchCustomerWithAccountsById(Long numClient);

	public ClientDtoEx saveNewEx(ClientDtoEx clientA);

}
