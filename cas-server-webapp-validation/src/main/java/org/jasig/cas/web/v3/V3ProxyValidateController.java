package org.jasig.cas.web.v3;

import org.jasig.cas.validation.ValidationSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Misagh Moayyed
 * @since 4.2
 */
@Component("v3ProxyValidateController")
@Controller
public class V3ProxyValidateController extends V3ServiceValidateController {
    /**
     * Handle model and view.
     *
     * @param request the request
     * @param response the response
     * @return the model and view
     * @throws Exception the exception
     */
    @RequestMapping(path="/p3/proxyValidate", method = RequestMethod.GET)
    @Override
    protected ModelAndView handle(final HttpServletRequest request, final HttpServletResponse response)
        throws Exception {
        return super.handleRequestInternal(request, response);
    }

    @Override
    @Autowired
    @Scope("prototype")
    public void setValidationSpecification(
            @Qualifier("cas20ProtocolValidationSpecification")
            final ValidationSpecification validationSpecification) {
        super.setValidationSpecification(validationSpecification);
    }

}
