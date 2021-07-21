Method number 0
Path: 2329961_1_corpus.json

@Test public void rapidChanges() throws Exception { final int maxPropagationTime = 100; final String pathPrefix = "/foo/rapido"; curator.create().creatingParentsIfNeeded().forPath(pathPrefix); final int numNodes = 50; final ListenerCounter listener = new ListenerCounter(numNodes, 0, numNodes); final NodeCollectionWatcher nodeCollectionWatcher = new NodeCollectionWatcher(zooKeeper, pathPrefix, listener); for (int i = 0; i < numNodes; i++) { curator.create().forPath(pathPrefix + "/node" + i, getData()); } assertTrue(listener.createLatch.await(maxPropagationTime, TimeUnit.MILLISECONDS)); assertThat(listener.createCount.get(), is(numNodes)); assertThat(listener.dataCount.get(), is(0)); assertThat(listener.removeCount.get(), is(0)); int total = 0; for (int j = 0; j < 5; j++) { listener.dataLatch = new CountDownLatch(numNodes); for (int i = 0; i < numNodes; i++) { curator.setData().forPath(pathPrefix + "/node" + i, getData()); } total += numNodes; assertTrue(listener.dataLatch.await(maxPropagationTime, TimeUnit.MILLISECONDS)); assertThat(listener.createCount.get(), is(numNodes)); assertThat(listener.dataCount.get(), is(total)); assertThat(listener.removeCount.get(), is(0)); } for (int i = 0; i < numNodes; i++) { curator.delete().forPath(pathPrefix + "/node" + i); } assertTrue(listener.removeLatch.await(maxPropagationTime, TimeUnit.MILLISECONDS)); assertThat(listener.createCount.get(), is(numNodes)); assertThat(listener.dataCount.get(), is(total)); assertThat(listener.removeCount.get(), is(numNodes)); nodeCollectionWatcher.shutdown(); }




Method number 1
Path: 152814648_160_corpus.json

@Test void shouldHaveNotMoreValuesThatAllowed() { SeverityTrendChart chart = new SeverityTrendChart(); ChartModelConfiguration configuration = mock(ChartModelConfiguration.class); when(configuration.getBuildCount()).thenReturn(3); when(configuration.getAxisType()).thenReturn(AxisType.BUILD); when(configuration.isBuildCountDefined()).thenReturn(true); List<BuildResult<AnalysisBuildResult>> results = new ArrayList<>(); results.add(createResult(4, 4000, 400, 40, 4)); results.add(createResult(3, 3000, 300, 30, 3)); results.add(createResult(2, 2000, 200, 20, 2)); results.add(createResult(1, 1000, 100, 10, 1)); LinesChartModel model = chart.create(results, configuration); verifySeries(model.getSeries().get(3), Severity.ERROR, 2000, 3000, 4000); verifySeries(model.getSeries().get(2), Severity.WARNING_HIGH, 200, 300, 400); verifySeries(model.getSeries().get(1), Severity.WARNING_NORMAL, 20, 30, 40); verifySeries(model.getSeries().get(0), Severity.WARNING_LOW, 2, 3, 4); assertThatJson(model).node("domainAxisLabels") .isArray().hasSize(3).containsExactly("#2", "#3", "#4"); assertThatJson(model).node("buildNumbers") .isArray().hasSize(3).containsExactly(2, 3, 4); assertThatJson(model).node("series") .isArray().hasSize(4); }




Method number 2
Path: 107330274_324_corpus.json

@Test public void testUpdate() { config.setProperty("anElastic", ".*Flex"); clock.advanceTime(1, TimeUnit.HOURS); List<ResourcePoolAssignment> result = resolver.resolve(newJob("myFlex")); assertThat(result).hasSize(1); assertThat(result.get(0).getResourcePoolName()).isEqualTo("anElastic"); }




Method number 3
Path: 2836228_12_corpus.json

@Test public void testGetNextStartTime3() throws Exception { Date now = getDate("2010-05-02 04:45 UTC"); Date start = getDate("1980-02-01 03:00 UTC"); Date newStart = getDate("2010-05-07 03:00 UTC"); Frequency frequency = new Frequency("days(7)"); Assert.assertEquals(newStart, EntityUtil.getNextStartTime(start, frequency, tz, now)); }




Method number 4
Path: 660443_2303_corpus.json

@Test(expected = UnsupportedOperationException.class) public void testRetainAll_Collection() { ConformerContainer container = new ConformerContainer(base); container.retainAll(null); }




Method number 5
Path: 9714608_267_corpus.json

@Test public void splitCharCharStr() throws Exception { String[] tab; tab = TextUtil.split('(',']',"(a](b](c](d]"); assertArrayEquals(new String[]{ "a", "b", "c", "d", }, tab); tab = TextUtil.split('(',']',"start (a]bbb (b eee](c](d]zzz end"); assertArrayEquals(new String[]{ "start", "a", "bbb", "b eee", "c", "d", "zzz end", }, tab); tab = TextUtil.split('(',']',"start (a]bbb (b (eee]](c](d]zzz end"); assertArrayEquals(new String[]{ "start", "a", "bbb", "b (eee]", "c", "d", "zzz end", }, tab); tab = TextUtil.split('(',']',"start (a]bbb (b (e(e(e]f]]](c](d]zzz end"); assertArrayEquals(new String[]{ "start", "a", "bbb", "b (e(e(e]f]]", "c", "d", "zzz end", }, tab); tab = TextUtil.split('(',']',"start (a]bbb (b (e(e(e]f]]](](d]zzz end"); assertArrayEquals(new String[]{ "start", "a", "bbb", "b (e(e(e]f]]", "", "d", "zzz end", }, tab); }




Method number 6
Path: 37717709_145_corpus.json

@Test public void testIdentifyGrammarNode() throws Exception { final String cr = System.getProperty("line.separator"); final VoiceXmlDocument document = new VoiceXmlDocument(); final Vxml vxml = document.getVxml(); final Form form = vxml.appendChild(Form.class); final Grammar grammar = form.appendChild(Grammar.class); grammar.setType(GrammarType.JSGF); final StringBuilder str = new StringBuilder(); str.append("#JSGF V1.0;"); str.append(cr); str.append("grammar jvoicexml;"); str.append(cr); str.append("public <boolean> = yes{true}|no{false};"); grammar.addCData(str.toString()); final GrammarDocument grammarDocument = new InternalGrammarDocument(grammar); final GrammarType type = identifier.identify(grammarDocument); Assert.assertEquals(GrammarType.JSGF, type); }




Method number 7
Path: 42032884_81_corpus.json

@Test public void testIsMainPageProps() { String text = "text"; WikiSite wiki = WikiSite.forLanguageCode("test"); final String thumbUrl = null; final String desc = null; PageProperties props = mock(PageProperties.class); when(props.isMainPage()).thenReturn(true); PageTitle subject = new PageTitle(text, wiki, thumbUrl, desc, props); assertThat(subject.isMainPage(), is(true)); }




Method number 8
Path: 660443_2521_corpus.json

@Test public void testMapping() throws Exception { IReactionProcess type = new RadicalSiteHrDeltaReaction(); IAtomContainerSet setOfReactants = getExampleReactants(); IAtomContainer molecule = setOfReactants.getAtomContainer(0); List<IParameterReact> paramList = new ArrayList<IParameterReact>(); IParameterReact param = new SetReactionCenter(); param.setParameter(Boolean.FALSE); paramList.add(param); type.setParameterList(paramList); IReactionSet setOfReactions = type.initiate(setOfReactants, null); IAtomContainer product = setOfReactions.getReaction(0).getProducts().getAtomContainer(0); Assert.assertEquals(18, setOfReactions.getReaction(0).getMappingCount()); IAtom mappedProductA1 = (IAtom) ReactionManipulator.getMappedChemObject(setOfReactions.getReaction(0), molecule.getAtom(0)); Assert.assertEquals(mappedProductA1, product.getAtom(0)); IAtom mappedProductA2 = (IAtom) ReactionManipulator.getMappedChemObject(setOfReactions.getReaction(0), molecule.getAtom(6)); Assert.assertEquals(mappedProductA2, product.getAtom(6)); IAtom mappedProductA3 = (IAtom) ReactionManipulator.getMappedChemObject(setOfReactions.getReaction(0), molecule.getAtom(7)); Assert.assertEquals(mappedProductA3, product.getAtom(7)); }




Method number 9
Path: 57061988_57_corpus.json

@Test public void getPassword_returnsDecryptedPassword_andOnlyDecryptsOnce() { final EncryptedValue encryption = new EncryptedValue(ENCRYPTION_KEY_UUID, ENCRYPTED_PASSWORD, NONCE); when(encryptor.decrypt(encryption)) .thenReturn(USER_PASSWORD); final EncryptedValue encryptedValue = new EncryptedValue(); encryptedValue.setEncryptedValue(ENCRYPTED_PASSWORD); encryptedValue.setNonce(NONCE); encryptedValue.setEncryptionKeyUuid(ENCRYPTION_KEY_UUID); userCredentialData = new UserCredentialVersionData(); userCredentialData.setEncryptedValueData(encryptedValue); subject = new UserCredentialVersion(userCredentialData); subject.setEncryptor(encryptor); final String password = subject.getPassword(); assertThat(password, equalTo(USER_PASSWORD)); verify(encryptor, times(1)).decrypt(any()); }




