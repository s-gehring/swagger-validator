package gehring.simon.hobby.swagger.testing.http;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StatusCode implements Serializable {

    private static final long serialVersionUID = 5954525744424693684L;
    private final Integer     code;
    private final String      title;
    private final String      msg;

    private static transient Map<Integer, StatusCode> codes = null;

    private static void initialize() {
        codes.put(100, new StatusCode(100, "Continue",
                "The server has received the request headers and the client should proceed to send the request body (in the case of a request for which a body needs to be sent; for example, a POST request). Sending a large request body to a server after a request has been rejected for inappropriate headers would be inefficient. To have a server check the request's headers, a client must send Expect: 100-continue as a header in its initial request and receive a 100 Continue status code in response before sending the body. If the client receives an error code such as 403 (Forbidden) or 405 (Method Not Allowed) then it shouldn't send the request's body. The response 417 Expectation Failed indicates that the request should be repeated without the Expect header as it indicates that the server doesn't support expectations (this is the case, for example, of HTTP/1.0 servers)."));
        codes.put(101, new StatusCode(101, "Switching Protocols",
                "The requester has asked the server to switch protocols and the server has agreed to do so."));
        codes.put(102, new StatusCode(102, "Processing (WebDAV; RFC 2518)",
                "A WebDAV request may contain many sub-requests involving file operations, requiring a long time to complete the request. This code indicates that the server has received and is processing the request, but no response is available yet. This prevents the client from timing out and assuming the request was lost."));
        codes.put(103, new StatusCode(103, "Early Hints (RFC 8297)",
                "Used to return some response headers before final HTTP message."));
        codes.put(200, new StatusCode(200, "OK",
                "Standard response for successful HTTP requests. The actual response will depend on the request method used. In a GET request, the response will contain an entity corresponding to the requested resource. In a POST request, the response will contain an entity describing or containing the result of the action."));
        codes.put(201, new StatusCode(201, "Created",
                "The request has been fulfilled, resulting in the creation of a new resource."));
        codes.put(202, new StatusCode(202, "Accepted",
                "The request has been accepted for processing, but the processing has not been completed. The request might or might not be eventually acted upon, and may be disallowed when processing occurs."));
        codes.put(203, new StatusCode(203, "Non-Authoritative Information (since HTTP/1.1)",
                "The server is a transforming proxy (e.g. a Web accelerator) that received a 200 OK from its origin, but is returning a modified version of the origin's response."));
        codes.put(204, new StatusCode(204, "No Content",
                "The server successfully processed the request and is not returning any content."));
        codes.put(205, new StatusCode(205, "Reset Content",
                "The server successfully processed the request, but is not returning any content. Unlike a 204 response, this response requires that the requester reset the document view."));
        codes.put(206, new StatusCode(206, "Partial Content (RFC 7233)",
                "The server is delivering only part of the resource (byte serving) due to a range header sent by the client. The range header is used by HTTP clients to enable resuming of interrupted downloads, or split a download into multiple simultaneous streams."));
        codes.put(207, new StatusCode(207, "Multi-Status (WebDAV; RFC 4918)",
                "The message body that follows is by default an XML message and can contain a number of separate response codes, depending on how many sub-requests were made."));
        codes.put(208, new StatusCode(208, "Already Reported (WebDAV; RFC 5842)",
                "The members of a DAV binding have already been enumerated in a preceding part of the (multistatus) response, and are not being included again."));
        codes.put(226, new StatusCode(226, "IM Used (RFC 3229)",
                "The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance."));
        codes.put(300, new StatusCode(300, "Multiple Choices",
                "Indicates multiple options for the resource from which the client may choose (via agent-driven content negotiation). For example, this code could be used to present multiple video format options, to list files with different filename extensions, or to suggest word-sense disambiguation."));
        codes.put(301, new StatusCode(301, "Moved Permanently",
                "This and all future requests should be directed to the given URI."));
        codes.put(302, new StatusCode(302, "Found (Previously \"Moved temporarily\")",
                "Tells the client to look at (browse to) another url. 302 has been superseded by 303 and 307. This is an example of industry practice contradicting the standard. The HTTP/1.0 specification (RFC 1945) required the client to perform a temporary redirect (the original describing phrase was \"Moved Temporarily\"), but popular browsers implemented 302 with the functionality of a 303 See Other. Therefore, HTTP/1.1 added status codes 303 and 307 to distinguish between the two behaviours. However, some Web applications and frameworks use the 302 status code as if it were the 303."));
        codes.put(303, new StatusCode(303, "See Other (since HTTP/1.1)",
                "The response to the request can be found under another URI using the GET method. When received in response to a POST (or PUT/DELETE), the client should presume that the server has received the data and should issue a new GET request to the given URI."));
        codes.put(304, new StatusCode(304, "Not Modified (RFC 7232)",
                "Indicates that the resource has not been modified since the version specified by the request headers If-Modified-Since or If-None-Match. In such case, there is no need to retransmit the resource since the client still has a previously-downloaded copy."));
        codes.put(305, new StatusCode(305, "Use Proxy (since HTTP/1.1)",
                "The requested resource is available only through a proxy, the address for which is provided in the response. Many HTTP clients (such as Mozilla and Internet Explorer) do not correctly handle responses with this status code, primarily for security reasons."));
        codes.put(306, new StatusCode(306, "Switch Proxy",
                "No longer used. Originally meant \"Subsequent requests should use the specified proxy.\""));
        codes.put(307, new StatusCode(307, "Temporary Redirect (since HTTP/1.1)",
                "In this case, the request should be repeated with another URI; however, future requests should still use the original URI. In contrast to how 302 was historically implemented, the request method is not allowed to be changed when reissuing the original request. For example, a POST request should be repeated using another POST request."));
        codes.put(308, new StatusCode(308, "Permanent Redirect (RFC 7538)",
                "The request and all future requests should be repeated using another URI. 307 and 308 parallel the behaviors of 302 and 301, but do not allow the HTTP method to change. So, for example, submitting a form to a permanently redirected resource may continue smoothly."));
        codes.put(400, new StatusCode(400, "Bad Request",
                "The server cannot or will not process the request due to an apparent client error (e.g., malformed request syntax, size too large, invalid request message framing, or deceptive request routing)."));
        codes.put(401, new StatusCode(401, "Unauthorized (RFC 7235)",
                "Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided. The response must include a WWW-Authenticate header field containing a challenge applicable to the requested resource. See Basic access authentication and Digest access authentication. 401 semantically means \"unauthenticated\", i.e. the user does not have the necessary credentials. Note: Some sites issue HTTP 401 when an IP address is banned from the website (usually the website domain) and that specific address is refused permission to access a website."));
        codes.put(402, new StatusCode(402, "Payment Required",
                "Reserved for future use. The original intention was that this code might be used as part of some form of digital cash or micropayment scheme, as proposed for example by GNU Taler, but that has not yet happened, and this code is not usually used. Google Developers API uses this status if a particular developer has exceeded the daily limit on requests. Sipgate uses this code if an account does not have sufficient funds to start a call."));
        codes.put(403, new StatusCode(403, "Forbidden",
                "The request was valid, but the server is refusing action. The user might not have the necessary permissions for a resource, or may need an account of some sort."));
        codes.put(404, new StatusCode(404, "Not Found",
                "The requested resource could not be found but may be available in the future. Subsequent requests by the client are permissible."));
        codes.put(405, new StatusCode(405, "Method Not Allowed",
                "A request method is not supported for the requested resource; for example, a GET request on a form that requires data to be presented via POST, or a PUT request on a read-only resource."));
        codes.put(406, new StatusCode(406, "Not Acceptable",
                "The requested resource is capable of generating only content not acceptable according to the Accept headers sent in the request. See Content negotiation."));
        codes.put(407, new StatusCode(407, "Proxy Authentication Required (RFC 7235)",
                "The client must first authenticate itself with the proxy."));
        codes.put(408, new StatusCode(408, "Request Timeout",
                "The server timed out waiting for the request. According to HTTP specifications: \"The client did not produce a request within the time that the server was prepared to wait. The client MAY repeat the request without modifications at any later time.\""));
        codes.put(409, new StatusCode(409, "Conflict",
                "Indicates that the request could not be processed because of conflict in the current state of the resource, such as an edit conflict between multiple simultaneous updates."));
        codes.put(410, new StatusCode(410, "Gone",
                "Indicates that the resource requested is no longer available and will not be available again. This should be used when a resource has been intentionally removed and the resource should be purged. Upon receiving a 410 status code, the client should not request the resource in the future. Clients such as search engines should remove the resource from their indices. Most use cases do not require clients and search engines to purge the resource, and a \"404 Not Found\" may be used instead."));
        codes.put(411, new StatusCode(411, "Length Required",
                "The request did not specify the length of its content, which is required by the requested resource."));
        codes.put(412, new StatusCode(412, "Precondition Failed (RFC 7232)",
                "The server does not meet one of the preconditions that the requester put on the request."));
        codes.put(413, new StatusCode(413, "Payload Too Large (RFC 7231)",
                "The request is larger than the server is willing or able to process. Previously called \"Request Entity Too Large\"."));
        codes.put(414, new StatusCode(414, "URI Too Long (RFC 7231)",
                "The URI provided was too long for the server to process. Often the result of too much data being encoded as a query-string of a GET request, in which case it should be converted to a POST request. Called \"Request-URI Too Long\" previously."));
        codes.put(415, new StatusCode(415, "Unsupported Media Type",
                "The request entity has a media type which the server or resource does not support. For example, the client uploads an image as image/svg+xml, but the server requires that images use a different format."));
        codes.put(416, new StatusCode(416, "Range Not Satisfiable (RFC 7233)",
                "The client has asked for a portion of the file (byte serving), but the server cannot supply that portion. For example, if the client asked for a part of the file that lies beyond the end of the file. Called \"Requested Range Not Satisfiable\" previously."));
        codes.put(417, new StatusCode(417, "Expectation Failed",
                "The server cannot meet the requirements of the Expect request-header field."));
        codes.put(418, new StatusCode(418, "I'm a teapot (RFC 2324, RFC 7168)",
                "This code was defined in 1998 as one of the traditional IETF April Fools' jokes, in RFC 2324, Hyper Text Coffee Pot Control Protocol, and is not expected to be implemented by actual HTTP servers. The RFC specifies this code should be returned by teapots requested to brew coffee. This HTTP status is used as an Easter egg in some websites, including Google.com."));
        codes.put(421, new StatusCode(421, "Misdirected Request (RFC 7540)",
                "The request was directed at a server that is not able to produce a response (for example because of connection reuse)."));
        codes.put(422, new StatusCode(422, "Unprocessable Entity (WebDAV; RFC 4918)",
                "The request was well-formed but was unable to be followed due to semantic errors."));
        codes.put(423,
                new StatusCode(423, "Locked (WebDAV; RFC 4918)",
                        "The resource that is being accessed is locked."));
        codes.put(424, new StatusCode(424, "Failed Dependency (WebDAV; RFC 4918)",
                "The request failed because it depended on another request and that request failed (e.g., a PROPPATCH)."));
        codes.put(426, new StatusCode(426, "Upgrade Required",
                "The client should switch to a different protocol such as TLS/1.0, given in the Upgrade header field."));
        codes.put(428, new StatusCode(428, "Precondition Required (RFC 6585)",
                "The origin server requires the request to be conditional. Intended to prevent the 'lost update' problem, where a client GETs a resource's state, modifies it, and PUTs it back to the server, when meanwhile a third party has modified the state on the server, leading to a conflict."));
        codes.put(429, new StatusCode(429, "Too Many Requests (RFC 6585)",
                "The user has sent too many requests in a given amount of time. Intended for use with rate-limiting schemes."));
        codes.put(431, new StatusCode(431, "Request Header Fields Too Large (RFC 6585)",
                "The server is unwilling to process the request because either an individual header field, or all the header fields collectively, are too large."));
        codes.put(451, new StatusCode(451, "Unavailable For Legal Reasons (RFC 7725)",
                "A server operator has received a legal demand to deny access to a resource or to a set of resources that includes the requested resource. The code 451 was chosen as a reference to the novel Fahrenheit 451 (see the Acknowledgements in the RFC)."));
        codes.put(500, new StatusCode(500, "Internal Server Error",
                "A generic error message, given when an unexpected condition was encountered and no more specific message is suitable."));
        codes.put(501, new StatusCode(501, "Not Implemented",
                "The server either does not recognize the request method, or it lacks the ability to fulfil the request. Usually this implies future availability (e.g., a new feature of a web-service API)."));
        codes.put(502, new StatusCode(502, "Bad Gateway",
                "The server was acting as a gateway or proxy and received an invalid response from the upstream server."));
        codes.put(503, new StatusCode(503, "Service Unavailable",
                "The server is currently unavailable (because it is overloaded or down for maintenance). Generally, this is a temporary state."));
        codes.put(504, new StatusCode(504, "Gateway Timeout",
                "The server was acting as a gateway or proxy and did not receive a timely response from the upstream server."));
        codes.put(505, new StatusCode(505, "HTTP Version Not Supported",
                "The server does not support the HTTP protocol version used in the request."));
        codes.put(506, new StatusCode(506, "Variant Also Negotiates (RFC 2295)",
                "Transparent content negotiation for the request results in a circular reference."));
        codes.put(507, new StatusCode(507, "Insufficient Storage (WebDAV; RFC 4918)",
                "The server is unable to store the representation needed to complete the request."));
        codes.put(508, new StatusCode(508, "Loop Detected (WebDAV; RFC 5842)",
                "The server detected an infinite loop while processing the request (sent in lieu of 208 Already Reported)."));
        codes.put(510, new StatusCode(510, "Not Extended (RFC 2774)",
                "Further extensions to the request are required for the server to fulfil it."));
        codes.put(511, new StatusCode(511, "Network Authentication Required (RFC 6585)",
                "The client needs to authenticate to gain network access. Intended for use by intercepting proxies used to control access to the network (e.g., \"captive portals\" used to require agreement to Terms of Service before granting full Internet access via a Wi-Fi hotspot)."));

    }

    private static synchronized void initializeIfNecessary() {
        if (codes == null) {
            codes = new HashMap<>();
            initialize();
        }

    }

    public static StatusCode getByCode(final Integer code) {
        initializeIfNecessary();
        return codes.get(code);
    }

    public Integer getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return msg;
    }

    private StatusCode(final Integer code, final String title, final String msg) {
        this.code = code;
        this.title = title;
        this.msg = msg;
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof StatusCode) {
            return ((StatusCode) obj).code.equals(this.code);
        }
        return false;
    }

}
