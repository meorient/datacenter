/** */
package ${pkgNameType}.${pkgNameCompany}.${subProjDirName}.service;

import org.springframework.stereotype.Service;
import ${pkgNameType}.${pkgNameCompany}.${subProjDirName}.service.BaseService;
import ${pkgNameType}.${pkgNameCompany}.${subProjDirName}.service.iservice.I${capClassName}Service;
import ${pkgNameType}.${pkgNameCompany}.${subProjDirName}.dao.${capClassName}Dao;
import ${pkgNameType}.${pkgNameCompany}.${subProjDirName}.pojo.${capClassName};

/**
 * @功能:【${tableName} ${tableComment}】Service
 * @项目名:${projectDirName}
 * @作者:${autherName}
 * @日期:${createTime?string('yyyy-MM-dd HH:mm:ss')}
 * @说明：<pre></pre>
 */
@Service
public class ${capClassName}Service extends BaseService<${capClassName}, ${capClassName}Dao> implements I${capClassName}Service {

}
