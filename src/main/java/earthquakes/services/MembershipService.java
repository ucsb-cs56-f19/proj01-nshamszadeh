package earthquakes.services;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

public interface MembershipService {

    /** is current logged in user a member but NOT an admin
     * @param oAuth2AuthenticationToken oauth token
     * @return is current logged in user a member but NOT an admin of the github org?
     **/
    public boolean isMember(OAuth2AuthenticationToken oAuth2AuthenticationToken);

    /** is current logged in user a member of the github org 
     * @param oAuth2AuthenticationToken oauth token
     * @return is the current logged in user an admin of the github org?
    */
    public boolean isAdmin(OAuth2AuthenticationToken oAuth2AuthenticationToken);

    /** i
     * @param oAuth2AuthenticationToken oauth token
     * @return s current logged in user a member or admin of the
     * github org */
    default public boolean isMemberOrAdmin(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        return isMember(oAuth2AuthenticationToken) || isAdmin(oAuth2AuthenticationToken);
    }

    default public String role(OAuth2AuthenticationToken token) {
        if (token==null)
            return "Guest";
        if (isMember(token))
            return "Member";
        if (isAdmin(token))
            return "Admin";
        return "Guest";
    }

}