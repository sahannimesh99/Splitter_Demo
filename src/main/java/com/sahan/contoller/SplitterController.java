package com.sahan.contoller;

import com.sahan.dto.ReqDto;
import com.sahan.service.SplitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sahan")
@CrossOrigin
@Slf4j
public class SplitterController {

    @Autowired
    private SplitterService splitterService;

    @PostMapping("/")
    public ResponseEntity<?> converter(@RequestBody ReqDto dto) {
        return ResponseEntity.ok(splitterService.convertInToArray(dto));
    }

    @PostMapping("/data")
    public Object convertData(@RequestBody Req data) {
        String[] vname = data.getVname().split("\\|");
        String[] vdesc = data.getVdesc().split("\\|");
        String[] vlifeassured = data.getVlifeassured().split("\\|");
        String[] vcoveramount = data.getVcoveramount().split("\\|");
        String[] vdateofexpire = data.getVdateofexpire().split("\\|");
        String[] vclaimamt = data.getVclaimamt().split("\\|");
        String[] vcovercode = data.getVcovercode().split("\\|");

        Cover[] covers = new Cover[vname.length];
        for (int i = 0; i < vname.length; i++) {
            Cover cover = new Cover();
            cover.setVname(vname[i].trim());
            cover.setVdesc(vdesc[i].trim());
            cover.setVlifeassured(vlifeassured[i].trim());
            cover.setVcoveramount(vcoveramount[i].trim());
            cover.setVdateofexpire(vdateofexpire[i].trim());
            cover.setVclaimamt(vclaimamt[i].trim());
            cover.setVcovercode(vcovercode[i].trim());
            covers[i] = cover;
        }

        Req convertedData = new Req();
        convertedData.setUserCode(data.getUserCode());
        convertedData.setErrorCode(data.getErrorCode());
        convertedData.setErrorMessage(data.getErrorMessage());
        convertedData.setSessionId(data.getSessionId());
        convertedData.setActionEvent(data.getActionEvent());
        convertedData.setRoleCode(data.getRoleCode());
        convertedData.setPolicyno(data.getPolicyno());
        convertedData.setCovers(covers);

        return convertedData;
    }

}

class Req {
    private String userCode;
    private String errorCode;
    private String errorMessage;
    private String sessionId;
    private String actionEvent;
    private String roleCode;
    private String policyno;
    private String vname;
    private String vdesc;
    private String vlifeassured;
    private String vcoveramount;
    private String vdateofexpire;
    private String vclaimamt;
    private String vcovercode;
    private Cover[] covers;

    public Req() {
    }

    public Req(String userCode, String errorCode, String errorMessage, String sessionId, String actionEvent, String roleCode, String policyno, String vname, String vdesc, String vlifeassured, String vcoveramount, String vdateofexpire, String vclaimamt, String vcovercode, Cover[] covers) {
        this.userCode = userCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.sessionId = sessionId;
        this.actionEvent = actionEvent;
        this.roleCode = roleCode;
        this.policyno = policyno;
        this.vname = vname;
        this.vdesc = vdesc;
        this.vlifeassured = vlifeassured;
        this.vcoveramount = vcoveramount;
        this.vdateofexpire = vdateofexpire;
        this.vclaimamt = vclaimamt;
        this.vcovercode = vcovercode;
        this.covers = covers;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getActionEvent() {
        return actionEvent;
    }

    public void setActionEvent(String actionEvent) {
        this.actionEvent = actionEvent;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getPolicyno() {
        return policyno;
    }

    public void setPolicyno(String policyno) {
        this.policyno = policyno;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVdesc() {
        return vdesc;
    }

    public void setVdesc(String vdesc) {
        this.vdesc = vdesc;
    }

    public String getVlifeassured() {
        return vlifeassured;
    }

    public void setVlifeassured(String vlifeassured) {
        this.vlifeassured = vlifeassured;
    }

    public String getVcoveramount() {
        return vcoveramount;
    }

    public void setVcoveramount(String vcoveramount) {
        this.vcoveramount = vcoveramount;
    }

    public String getVdateofexpire() {
        return vdateofexpire;
    }

    public void setVdateofexpire(String vdateofexpire) {
        this.vdateofexpire = vdateofexpire;
    }

    public String getVclaimamt() {
        return vclaimamt;
    }

    public void setVclaimamt(String vclaimamt) {
        this.vclaimamt = vclaimamt;
    }

    public String getVcovercode() {
        return vcovercode;
    }

    public void setVcovercode(String vcovercode) {
        this.vcovercode = vcovercode;
    }

    public Cover[] getCovers() {
        return covers;
    }

    public void setCovers(Cover[] covers) {
        this.covers = covers;
    }
// Getters and Setters
}

class Cover {
    private String vname;
    private String vdesc;
    private String vlifeassured;
    private String vcoveramount;
    private String vdateofexpire;
    private String vclaimamt;
    private String vcovercode;

    public Cover() {
    }

    public Cover(String vname, String vdesc, String vlifeassured, String vcoveramount, String vdateofexpire, String vclaimamt, String vcovercode) {
        this.vname = vname;
        this.vdesc = vdesc;
        this.vlifeassured = vlifeassured;
        this.vcoveramount = vcoveramount;
        this.vdateofexpire = vdateofexpire;
        this.vclaimamt = vclaimamt;
        this.vcovercode = vcovercode;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVdesc() {
        return vdesc;
    }

    public void setVdesc(String vdesc) {
        this.vdesc = vdesc;
    }

    public String getVlifeassured() {
        return vlifeassured;
    }

    public void setVlifeassured(String vlifeassured) {
        this.vlifeassured = vlifeassured;
    }

    public String getVcoveramount() {
        return vcoveramount;
    }

    public void setVcoveramount(String vcoveramount) {
        this.vcoveramount = vcoveramount;
    }

    public String getVdateofexpire() {
        return vdateofexpire;
    }

    public void setVdateofexpire(String vdateofexpire) {
        this.vdateofexpire = vdateofexpire;
    }

    public String getVclaimamt() {
        return vclaimamt;
    }

    public void setVclaimamt(String vclaimamt) {
        this.vclaimamt = vclaimamt;
    }

    public String getVcovercode() {
        return vcovercode;
    }

    public void setVcovercode(String vcovercode) {
        this.vcovercode = vcovercode;
    }

    // Getters and Setters
}

