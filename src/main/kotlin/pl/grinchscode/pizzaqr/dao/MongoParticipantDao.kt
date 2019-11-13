package pl.grinchscode.pizzaqr.dao

import org.litote.kmongo.contains
import pl.grinchscode.pizzaqr.model.Participant

class MongoParticipantDao(database: MongoDatabase) : ParticipantDao
{
    private val collection = database.getCollection<Participant>()

    override suspend fun findParticipantByToken(token: String) = collection.findOne(Participant::tokens contains token)
}
