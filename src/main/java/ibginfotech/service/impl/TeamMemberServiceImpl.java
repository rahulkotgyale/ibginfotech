package ibginfotech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibginfotech.entity.TeamMember;
import ibginfotech.repository.TeamMemberRepository;
import ibginfotech.service.TeamMemberService;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    @Autowired
    private TeamMemberRepository repo;

    @Override
    public TeamMember create(TeamMember member) {
        return repo.save(member);
    }

    @Override
    public List<TeamMember> getAll() {
        return repo.findAll();
    }

    @Override
    public TeamMember getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("TeamMember not found with id " + id));
    }

    @Override
    public TeamMember update(Long id, TeamMember member) {
        TeamMember existing = getById(id);
        existing.setName(member.getName());
        existing.setPosition(member.getPosition());
        existing.setBio(member.getBio());
        existing.setPhoto(member.getPhoto());
        existing.setLinkedin(member.getLinkedin());
        existing.setTwitter(member.getTwitter());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
