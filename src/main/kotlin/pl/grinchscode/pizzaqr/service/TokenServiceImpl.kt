package pl.grinchscode.pizzaqr.service

import pl.grinchscode.pizzaqr.dao.TokenDao
import pl.grinchscode.pizzaqr.model.Token

class TokenServiceImpl(private val tokenDao: TokenDao) : TokenService
{
	override suspend fun isTokenActive(token: String) = tokenDao.findToken(token)?.active

	override suspend fun addToken(token: Token) = tokenDao.insertToken(token)
}
