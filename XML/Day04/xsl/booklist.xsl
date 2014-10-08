<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0">
    
    <!-- 시작 템플릿 룰 -->
    <xsl:template match="/">
        <html>
            <body>
                <h2><font color="blue">Our Book List</font></h2>
                <table border="1" cellspacing="0" width="80%">
                    <tr bgcolor="#ffff66">
                        <th>title</th>
                        <th>author</th>
                    </tr>
                    
                    <xsl:apply-templates select="/booklist/book" />
                    
                </table>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="book">
        <tr>
            <td><xsl:value-of select="title"/></td>
            <td><xsl:value-of select="author"/></td>
        </tr>
    </xsl:template>
    
</xsl:stylesheet>