package pl.grinchscode.pizzaqr.service.auth

import io.ktor.auth.Principal
import io.ktor.auth.UserPasswordCredential

interface AuthService
{
	fun authenticate(credentials: UserPasswordCredential): Principal
}
