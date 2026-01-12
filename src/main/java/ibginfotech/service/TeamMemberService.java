package ibginfotech.service;

import java.util.List;
import ibginfotech.entity.TeamMember;

public interface TeamMemberService {
    TeamMember create(TeamMember member);
    List<TeamMember> getAll();
    TeamMember getById(Long id);
    TeamMember update(Long id, TeamMember member);
    void delete(Long id);
}
