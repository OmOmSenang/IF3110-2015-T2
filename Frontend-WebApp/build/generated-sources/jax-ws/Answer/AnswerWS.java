
package Answer;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AnswerWS", targetNamespace = "http://AnswerModule/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AnswerWS {


    /**
     * 
     * @param accessToken
     * @param aid
     * @param qid
     * @param content
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "UpdateAnswer")
    @WebResult(name = "Status", targetNamespace = "")
    @RequestWrapper(localName = "UpdateAnswer", targetNamespace = "http://AnswerModule/", className = "Answer.UpdateAnswer")
    @ResponseWrapper(localName = "UpdateAnswerResponse", targetNamespace = "http://AnswerModule/", className = "Answer.UpdateAnswerResponse")
    @Action(input = "http://AnswerModule/AnswerWS/UpdateAnswerRequest", output = "http://AnswerModule/AnswerWS/UpdateAnswerResponse")
    public String updateAnswer(
        @WebParam(name = "access_token", targetNamespace = "")
        String accessToken,
        @WebParam(name = "content", targetNamespace = "")
        String content,
        @WebParam(name = "aid", targetNamespace = "")
        int aid,
        @WebParam(name = "qid", targetNamespace = "")
        int qid);

    /**
     * 
     * @param up
     * @param accessToken
     * @param qid
     * @param aid
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "Status", targetNamespace = "")
    @RequestWrapper(localName = "voteAnswer", targetNamespace = "http://AnswerModule/", className = "Answer.VoteAnswer")
    @ResponseWrapper(localName = "voteAnswerResponse", targetNamespace = "http://AnswerModule/", className = "Answer.VoteAnswerResponse")
    @Action(input = "http://AnswerModule/AnswerWS/voteAnswerRequest", output = "http://AnswerModule/AnswerWS/voteAnswerResponse")
    public String voteAnswer(
        @WebParam(name = "qid", targetNamespace = "")
        int qid,
        @WebParam(name = "aid", targetNamespace = "")
        int aid,
        @WebParam(name = "up", targetNamespace = "")
        boolean up,
        @WebParam(name = "access_token", targetNamespace = "")
        String accessToken);

    /**
     * 
     * @param qid
     * @return
     *     returns java.util.List<Answer.Answer>
     */
    @WebMethod(operationName = "GetAllAnswer")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetAllAnswer", targetNamespace = "http://AnswerModule/", className = "Answer.GetAllAnswer")
    @ResponseWrapper(localName = "GetAllAnswerResponse", targetNamespace = "http://AnswerModule/", className = "Answer.GetAllAnswerResponse")
    @Action(input = "http://AnswerModule/AnswerWS/GetAllAnswerRequest", output = "http://AnswerModule/AnswerWS/GetAllAnswerResponse")
    public List<Answer> getAllAnswer(
        @WebParam(name = "qid", targetNamespace = "")
        int qid);

    /**
     * 
     * @param accessToken
     * @param qid
     * @param content
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "InsertAnswer")
    @WebResult(name = "Status", targetNamespace = "")
    @RequestWrapper(localName = "InsertAnswer", targetNamespace = "http://AnswerModule/", className = "Answer.InsertAnswer")
    @ResponseWrapper(localName = "InsertAnswerResponse", targetNamespace = "http://AnswerModule/", className = "Answer.InsertAnswerResponse")
    @Action(input = "http://AnswerModule/AnswerWS/InsertAnswerRequest", output = "http://AnswerModule/AnswerWS/InsertAnswerResponse")
    public String insertAnswer(
        @WebParam(name = "access_token", targetNamespace = "")
        String accessToken,
        @WebParam(name = "qid", targetNamespace = "")
        int qid,
        @WebParam(name = "content", targetNamespace = "")
        String content);

    /**
     * 
     * @param accessToken
     * @param aid
     * @param qid
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "DeleteAnswer")
    @WebResult(name = "Status", targetNamespace = "")
    @RequestWrapper(localName = "DeleteAnswer", targetNamespace = "http://AnswerModule/", className = "Answer.DeleteAnswer")
    @ResponseWrapper(localName = "DeleteAnswerResponse", targetNamespace = "http://AnswerModule/", className = "Answer.DeleteAnswerResponse")
    @Action(input = "http://AnswerModule/AnswerWS/DeleteAnswerRequest", output = "http://AnswerModule/AnswerWS/DeleteAnswerResponse")
    public String deleteAnswer(
        @WebParam(name = "access_token", targetNamespace = "")
        String accessToken,
        @WebParam(name = "aid", targetNamespace = "")
        int aid,
        @WebParam(name = "qid", targetNamespace = "")
        int qid);

}