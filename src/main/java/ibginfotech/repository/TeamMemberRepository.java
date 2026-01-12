package ibginfotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ibginfotech.entity.TeamMember;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
}
