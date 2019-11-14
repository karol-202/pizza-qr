package pl.grinchscode.pizzaqr.service.auth

import io.ktor.auth.Principal
import io.ktor.auth.UserPasswordCredential

class AuthServiceImpl(private val username: String,
                      private val password: String) : AuthService
{
	private val principal = object : Principal {}

	override fun authenticate(credentials: UserPasswordCredential) =
		if(credentials.name == username && credentials.password == password) principal else null
}
