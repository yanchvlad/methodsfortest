Method number 0
Path: 2329961_1_corpus.json

public void shutdown() { shuttingDown.set(true); }




Method number 1
Path: 152814648_160_corpus.json

@Override public LinesChartModel create(final Iterable<? extends BuildResult<AnalysisBuildResult>> results, final ChartModelConfiguration configuration) { SeveritySeriesBuilder builder = new SeveritySeriesBuilder(); LinesDataSet dataSet = builder.createDataSet(configuration, results); return createChartFromDataSet(dataSet); }




Method number 2
Path: 107330274_324_corpus.json

@Override public List<ResourcePoolAssignment> resolve(Job<?> job) { ApplicationSLA capacityGroup = JobManagerUtil.getCapacityGroupDescriptor(job.getJobDescriptor(), capacityGroupService); if (capacityGroup == null) { return Collections.emptyList(); } List<Pair<String, Pattern>> currentMappers = getCurrentMappers(); for (Pair<String, Pattern> next : currentMappers) { Pattern pattern = next.getRight(); if (pattern.matcher(capacityGroup.getAppName()).matches()) { return Collections.singletonList(ResourcePoolAssignment.newBuilder() .withResourcePoolName(next.getLeft()) .withRule(String.format("Capacity group %s matches %s", capacityGroup.getAppName(), pattern.toString())) .build() ); } } return Collections.emptyList(); }




Method number 3
Path: 2836228_12_corpus.json

public static Date getNextStartTime(Date startTime, Frequency frequency, TimeZone timezone, Date now) { if (startTime.after(now)) return startTime; Calendar startCal = Calendar.getInstance(timezone); startCal.setTime(startTime); int count = 0; switch (frequency.getTimeUnit()) { case months: count = (int) ((now.getTime() - startTime.getTime()) / MONTH_IN_MS); break; case days: count = (int) ((now.getTime() - startTime.getTime()) / DAY_IN_MS); break; case hours: count = (int) ((now.getTime() - startTime.getTime()) / HOUR_IN_MS); break; case minutes: count = (int) ((now.getTime() - startTime.getTime()) / MINUTE_IN_MS); break; default: } if (count > 2) { startCal.add(frequency.getTimeUnit().getCalendarUnit(), ((count - 2) / frequency.getFrequency()) * frequency.getFrequency()); } while (startCal.getTime().before(now)) { startCal.add(frequency.getTimeUnit().getCalendarUnit(), frequency.getFrequency()); } return startCal.getTime(); }




Method number 4
Path: 660443_2303_corpus.json

@Override public boolean retainAll(Collection<?> objects) { throw new UnsupportedOperationException(); }




Method number 5
Path: 9714608_267_corpus.json

@Pure public static String[] split(char leftSeparator, char rightSeparator, String str) { final SplitSeparatorToArrayAlgorithm algo = new SplitSeparatorToArrayAlgorithm(); splitSeparatorAlgorithm(leftSeparator, rightSeparator, str, algo); return algo.toArray(); }




Method number 6
Path: 37717709_145_corpus.json

@Override public GrammarType identify(final GrammarDocument grammar) { if (grammar == null) { if (LOGGER.isDebugEnabled()) { LOGGER.debug("grammar is null or empty"); } return null; } if (!grammar.isAscii()) { if (LOGGER.isDebugEnabled()) { LOGGER.debug("can only handle ascii grammars"); } return null; } final String document = grammar.getTextContent(); if (document.startsWith(JSGF_HEDAER)) { return GrammarType.JSGF; } final StringTokenizer tok = new StringTokenizer(document, ";"); if (!tok.hasMoreTokens()) { return null; } final String header = tok.nextToken(); if (header.startsWith(JSGF_HEDAER)) { return GrammarType.JSGF; } return null; }




Method number 7
Path: 42032884_81_corpus.json

public boolean isMainPage() { return properties != null && properties.isMainPage(); }




Method number 8
Path: 660443_2521_corpus.json

@Override public IReactionSet initiate(IAtomContainerSet reactants, IAtomContainerSet agents) throws CDKException { logger.debug("initiate reaction: RadicalSiteHrDeltaReaction"); if (reactants.getAtomContainerCount() != 1) { throw new CDKException("RadicalSiteHrDeltaReaction only expects one reactant"); } if (agents != null) { throw new CDKException("RadicalSiteHrDeltaReaction don't expects agents"); } IReactionSet setOfReactions = reactants.getBuilder().newInstance(IReactionSet.class); IAtomContainer reactant = reactants.getAtomContainer(0); AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(reactant); Aromaticity.cdkLegacy().apply(reactant); AllRingsFinder arf = new AllRingsFinder(); IRingSet ringSet = arf.findAllRings(reactant); for (int ir = 0; ir < ringSet.getAtomContainerCount(); ir++) { IRing ring = (IRing) ringSet.getAtomContainer(ir); for (int jr = 0; jr < ring.getAtomCount(); jr++) { IAtom aring = ring.getAtom(jr); aring.setFlag(CDKConstants.ISINRING, true); } } IParameterReact ipr = super.getParameterClass(SetReactionCenter.class); if (ipr != null && !ipr.isSetParameter()) setActiveCenters(reactant); HOSECodeGenerator hcg = new HOSECodeGenerator(); Iterator<IAtom> atomis = reactant.atoms().iterator(); while (atomis.hasNext()) { IAtom atomi = atomis.next(); if (atomi.getFlag(CDKConstants.REACTIVE_CENTER) && reactant.getConnectedSingleElectronsCount(atomi) == 1) { hcg.getSpheres(reactant, atomi, 5, true); Iterator<IAtom> atomls = hcg.getNodesInSphere(5).iterator(); while (atomls.hasNext()) { IAtom atoml = atomls.next(); if (atoml != null && atoml.getFlag(CDKConstants.REACTIVE_CENTER) && !atoml.getFlag(CDKConstants.ISINRING) && (atoml.getFormalCharge() == CDKConstants.UNSET ? 0 : atoml.getFormalCharge()) == 0 && !atoml.getSymbol().equals("H") && reactant.getMaximumBondOrder(atoml) == IBond.Order.SINGLE) { Iterator<IAtom> atomhs = reactant.getConnectedAtomsList(atoml).iterator(); while (atomhs.hasNext()) { IAtom atomh = atomhs.next(); if (reactant.getBond(atomh, atoml).getFlag(CDKConstants.REACTIVE_CENTER) && atomh.getFlag(CDKConstants.REACTIVE_CENTER) && atomh.getSymbol().equals("H")) { ArrayList<IAtom> atomList = new ArrayList<IAtom>(); atomList.add(atomh); atomList.add(atomi); atomList.add(atoml); ArrayList<IBond> bondList = new ArrayList<IBond>(); bondList.add(reactant.getBond(atomh, atoml)); IAtomContainerSet moleculeSet = reactant.getBuilder().newInstance( IAtomContainerSet.class); moleculeSet.addAtomContainer(reactant); IReaction reaction = mechanism.initiate(moleculeSet, atomList, bondList); if (reaction == null) continue; else setOfReactions.addReaction(reaction); } } } } } } return setOfReactions; }




Method number 9
Path: 57061988_57_corpus.json

public String getPassword() { this.password = (String) super.getValue(); return this.password; }




