package com.pfseven.smdb.report;

public interface BackupManager {
    void exportEverythingToCSV();

    void exportPeopleToCSV();

    void exportMoviesToCSV();

    void exportSeriesToCSV();

    void exportEpisodesToCSV();
}
