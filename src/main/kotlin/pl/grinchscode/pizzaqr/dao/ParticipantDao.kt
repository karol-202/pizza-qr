package pl.grinchscode.pizzaqr.dao

import pl.grinchscode.pizzaqr.model.Participant

interface ParticipantDao
{
    suspend fun findParticipantByToken(token: String): Participant?
}
