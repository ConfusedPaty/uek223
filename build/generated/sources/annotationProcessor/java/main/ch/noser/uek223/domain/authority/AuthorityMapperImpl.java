package ch.noser.uek223.domain.authority;

import ch.noser.uek223.domain.authority.dto.AuthorityDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-11T16:41:42+0100",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.2.jar, environment: Java 15 (Oracle Corporation)"
)
@Component
public class AuthorityMapperImpl implements AuthorityMapper {

    @Override
    public AuthorityDTO authorityToAuthorityDTO(Authority authority) {
        if ( authority == null ) {
            return null;
        }

        AuthorityDTO authorityDTO = new AuthorityDTO();

        authorityDTO.setId( authority.getId() );
        authorityDTO.setName( authority.getName() );

        return authorityDTO;
    }

    @Override
    public List<AuthorityDTO> authoritiesToAuthorityDTOs(List<Authority> authority) {
        if ( authority == null ) {
            return null;
        }

        List<AuthorityDTO> list = new ArrayList<AuthorityDTO>( authority.size() );
        for ( Authority authority1 : authority ) {
            list.add( authorityToAuthorityDTO( authority1 ) );
        }

        return list;
    }
}
