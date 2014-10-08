<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0"
    xmlns:b="http://www.bitacademy.com/schema/booklist">
    
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
                    
                    <xsl:apply-templates select="/b:booklist/b:book" />
                    
                </table>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="b:book">
        <tr>
            <td><xsl:value-of select="b:title"/></td>
            <td><xsl:value-of select="b:author"/></td>
        </tr>
    </xsl:template>
    
</xsl:stylesheet>