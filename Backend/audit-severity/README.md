# CDE-MFPE-Project-Audit-Management-System

## Authors :

<table>
  <tr>
      <td>
        <a href="https://github.com/RupeshLal">Rupesh Lal</a>
        </td>
      <td>
        <a href="https://github.com/mirzashifa">Shifa Mirza</a>
        </td>
      <td>
        <a href="https://github.com/meenalbaberwal">Meenal Santosh Baberwal</a>
        </td>
      <td>
        <a href="https://github.com/raaniji72">Satyabrata Pramanik</a>
        </td>
      <td>
        <a href="https://github.com/nikhil312000">Nikhil Kishor Shevalkar</a>
        </td>
    </tr>
</table>

## Module Name :

* ### Audit-Severity-Microservice :
  This module is used for checking the severity of the audit by invoking the *Benchmark* and *Checklist*  Microservice as Request from the portal.
  This microservice will return the status of the audit response by giving the project execution status and the remedial action.

  * #### --Endpoints : 
    <table>
        <thead>
            <th>Method</th>
            <th>Endpoint Path</th>
            <th>Returns</th>
        </thead>
        <tbody>
            <tr>
                <td>POST</td>
                <td>/ProjectExecutionStatus</td>
                <td>Audit Severity</td>
            </tr>
        </tbody>
    </table>

  * #### --Dependencies on Other microsevices : *Audit-Authorization,Audit-Checklist,Audit-Benchmark*

  * #### --Application Properties Toggle :<br/>
      spring.application.name=AuditSeverity<br/>
      server.port=8300<br/>
      server.servlet.context-path=/severity<br/>
      User Database : H2(In-Memory)<br/>
