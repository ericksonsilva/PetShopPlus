package br.com.petshopplus.safety;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;

@Intercepts
public class AutorizacaoInterceptor implements Interceptor{

	
	private final Result result;

	public AutorizacaoInterceptor(Result result) {
		this.result = result;
	}
	
	public boolean accepts(ControllerMethod method) {
		return !Session.isLogado() && method.containsAnnotation(Restrito.class);
	}

	
	public void intercept(InterceptorStack stack, ControllerMethod method,
		Object resourceInstance) throws InterceptionException {		
		result.redirectTo("/");
	}

}
