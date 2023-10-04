package com.medkissi.cryptocurrency.data.mapper

import com.medkissi.cryptocurrency.data.dto.TeamMemberDto
import com.medkissi.cryptocurrency.domain.model.TeamMember

fun TeamMemberDto.toTeamMember():TeamMember{
    return TeamMember(
        id = id,
        name = name,
        position = position
    )
}