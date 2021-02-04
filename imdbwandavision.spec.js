// Generated by Selenium IDE
const { Builder, By, Key, until, Capabilities } = require('selenium-webdriver')
const assert = require('assert')

describe('imdb-wandavision', function() {
  this.timeout(30000)
  let driver
  let vars
  let capabilities = Capabilities.firefox()
  before(async function() {
    driver = await new Builder().usingServer("http://172.21.0.1:4444").withCapabilities(capabilities).build()
    vars = {}
  })
  afterEach(async function() {
    await driver.quit();
  })
  it('imdb-wandavision', async function() {
    // Test name: imdb-wandavision
    // Step # | name | target | value | comment
    // 1 | open | / |  | 
    await driver.get("https://www.imdb.com//")
    // 2 | setWindowSize | 835x691 |  | 
    await driver.manage().window().setRect(835, 691)
    // 3 | type | id=suggestion-search | wandavision | 
    await driver.findElement(By.id("suggestion-search")).sendKeys("wandavision")
    // 4 | click | css=.\_2mXTyZmtWnrwCBj9tuEhuK .\_2NPnhnjxKTlB8HDsb7RtwX |  | 
    await driver.findElement(By.css(".\\_2mXTyZmtWnrwCBj9tuEhuK .\\_2NPnhnjxKTlB8HDsb7RtwX")).click()
    // 5 | click | css=.bp_content |  | 
    await driver.findElement(By.css(".bp_content")).click()
    // 6 | runScript | window.scrollTo(0,0) |  | 
    await driver.executeScript("window.scrollTo(0,0)")
  })
})
