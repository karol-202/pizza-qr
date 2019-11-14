package pl.grinchscode.pizzaqr.service.token

import pl.grinchscode.pizzaqr.dao.TokenDao
import pl.grinchscode.pizzaqr.model.Token

class TokenServiceImpl(private val tokenDao: TokenDao) : TokenService
{
	override suspend fun addToken(token: Token) = tokenDao.insertToken(token)

	override suspend fun useToken(token: String) =
		tokenDao.findToken(token)?.active?.also { if(it) tokenDao.updateToken(token, false) }
}
