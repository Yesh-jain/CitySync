package com.IOE.cs.city_sync.Repos;

import com.IOE.cs.city_sync.DTOs.MeetingsDTO;
import com.IOE.cs.city_sync.Entities.CSUser;
import com.IOE.cs.city_sync.Entities.Meetings;
import com.IOE.cs.city_sync.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRepo extends JpaRepository<Meetings, Integer> {

    List<Meetings> getMeetingByParticipatingUser(CSUser byUsername);
}
